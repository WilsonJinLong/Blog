package com.fleam.blog;

import com.fleam.blog.entity.*;
import com.fleam.blog.service.IInventoryLogService;
import com.fleam.blog.service.IInventoryService;
import com.fleam.blog.service.ILocationService;
import com.fleam.base.util.DateUtils;
import com.fleam.base.util.MyStringUtil;
import com.fleam.base.util.XmlUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class ReadInventory {

    @Autowired
    private IInventoryService inventoryService;

    @Autowired
    private ILocationService locationService;

    @Autowired
    private IInventoryLogService inventoryLogService;

    @Test
    public  void addInventory() throws ParseException {

        InventoryLog inventoryLog = new InventoryLog();
        inventoryLog.setCreateTime(DateUtils.formatDate("2019-01-08 00:00:00"));
        inventoryLog.setMark(1);//1:主 2:备
        inventoryLogService.save(inventoryLog);

        File file=new File("D:\\Workspace\\back-end-doc\\e-wms\\log\\Inventory.2019-01-08.0\\Inventory.2019-01-08.0");
        BufferedReader reader=null;
        String temp=null;
        int line=1;
        try{
            reader=new BufferedReader(new FileReader(file));
            while((temp=reader.readLine())!=null){

                //获取时间
                String str = "line：" + temp + "**end";
                String dateString = MyStringUtil.subString(str,"line："," INFO ");

                //获取类型和内容
                if(MyStringUtil.inString(str,"返回")){
                    String content = MyStringUtil.subString(str,"库存查询返回：","**end");

                    //遍历
                    List<Object> item = XmlUtils.readXML(content,"items", "item", InventoryDTO.class);
                    List<InventoryDTO> list = new ArrayList<InventoryDTO>();
                    for (int i = 0; i < item.size(); i++) {
                        list.add((InventoryDTO) item.get(i));
                    }
                    List<Inventory> inventories = new ArrayList<Inventory>();
                    for (int j = 0; j < list.size(); j++) {
                        Inventory inventory = new Inventory();
                        BeanUtils.copyProperties(list.get(j),inventory);
                        if(list.get(j).getExpireDate()!=null){
                            inventory.setExpireDate(DateUtils.formatDate(list.get(j).getExpireDate()+" 00:00:00"));
                        }
                        inventory.setCreateTime(DateUtils.formatDate(dateString));
                        inventories.add(inventory);
                    }
                    for(Inventory obj : inventories){
                        inventoryService.save(obj);
                    }

                }
                if(MyStringUtil.inString(str,"收到")){
                    String content = MyStringUtil.subString(str,"库存查询收到的参数：","**end");

                    //遍历
                    List<Object> item = XmlUtils.readXML(content,"criteriaList", "criteria", LocationDTO.class);
                    List<LocationDTO> list = new ArrayList<LocationDTO>();
                    for (int i = 0; i < item.size(); i++) {
                        list.add((LocationDTO) item.get(i));
                    }
                    List<Location> Locations = new ArrayList<Location>();
                    for (int j = 0; j < list.size(); j++) {
                        Location location = new Location();
                        BeanUtils.copyProperties(list.get(j),location);
                        location.setCreateTime(DateUtils.formatDate(dateString));
                        Locations.add(location);
                    }
                    for(Location obj : Locations){
                        locationService.save(obj);
                    }

                }

                line++;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(reader!=null){
                try{
                    reader.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
