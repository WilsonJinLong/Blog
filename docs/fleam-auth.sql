/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : fleam-auth

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 14/01/2019 21:21:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标签',
  `context` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章正文',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (53, '将进酒', '随笔', '君不见，黄河之水天上来，奔流到海不复回。\n君不见，高堂明镜悲白发，朝如青丝暮成雪。\n人生得意须尽欢，莫使金樽空对月。\n天生我材必有用，千金散尽还复来。\n烹羊宰牛且为乐，会须一饮三百杯。\n岑夫子，丹丘生，将进酒，杯莫停。\n与君歌一曲，请君为我倾耳听。(倾耳听 一作：侧耳听)\n钟鼓馔玉不足贵，但愿长醉不复醒。(不足贵 一作：何足贵；不复醒 一作：不愿醒/不用醒)\n古来圣贤皆寂寞，惟有饮者留其名。(古来 一作：自古；惟 通：唯)\n陈王昔时宴平乐，斗酒十千恣欢谑。\n主人何为言少钱，径须沽取对君酌。\n五花马，千金裘，呼儿将出换美酒，与尔同销万古愁。', '2019-01-14 20:55:07');
INSERT INTO `article` VALUES (54, '证道歌', '随笔', '永嘉大师《证道歌》调古神清，有足多者，而宏德上人注释亦有独到处。今熔于一炉，间参我见，作解脱歌。\n\n觉后乐，乐如何？听我教唱解脱歌，不让古人风调高，我今何妨拈句和。\n本无妄，亦无真，原来二法空无性，无住无相不着空，即是如来真实性。\n见实相，诸法空，刹那顿悟万法同，一旦风光藏不住，赤裸裸的觌面逢。\n决定说，佛心印，有人不肯如实信，直截根源当下了，摘叶寻枝渐教人。\n几回生，几回死，亘古亘今常如此，神头鬼面有多般，返本还元没些子。\n习显教，修密宗，方便门异归原同，自从踏遍涅槃路，了知生死本来空。\n行也空，坐也空，语默动静无不空，纵将白刃临头颅，犹如利剑斩春风。\n顿觉了，妙心源，无明壳裂总一般，梦里明明有六趣，觉后空空无圣凡。\n烦恼本，即菩提，罪福没性何处觅，无绳自缚解脱后，大摇大摆大休息。\n莫攀缘，莫执着，随缘随份随饮啄，不变随缘行无碍，自在随心大安乐。\n但得本，莫愁末，妙用纵横活泼泼，弹指敲开不二门，升堂直入如来屋。\n宗亦通，说亦通，团团杲日丽晴空，百千三昧无量义，只在寻常日用中。\n觉心体，生佛同，有情无情共鼻孔，无缚无脱无遮障，迷时无碍悟自通。\n无形相，极灵妙，非亲证知那能晓，镜里看影虽不难，水底捉月怎办到！\n狮子吼，无畏说，百兽闻之皆咋舌，香象奔波失却威，天龙寂听生欣悦。\n狮子儿，众随后，三岁即能大啸吼，若是野犴逐法王，百千妖怪虚开口。\n谁无念，谁无生，莫将镜影认作真，若以断灭为究竟，何以外道邪见人。\n大丈夫，秉慧剑，般若锋兮金刚焰，非但能摧外道心，并且破除邪魔见。\n震法雷，击法鼓，海水奔腾须弥舞，毛头许里乾坤定，大千沙界寸土无。\n让他谤，任他毁，把火烧天徒自累，我闻恰是空中风，何碍甚深大三昧！\n一切声，皆实相，恶言善语无二样，不因谤赞别冤亲，方契本心平等相。\n赞无增，谤无减，空中鸟迹着云天，太虚饮光消契阔，幽谷回声话晚烟。\n默时说，说时默，大施门开无壅塞，有人问我解何宗，我为摩诃般若客。\n昔曾说，今懒说，山河大地广长舌，或是或非人不识，逆行顺行天莫测！\n常独行，常独步，脚底草鞋狞似虎，举趾粉碎金刚地，不觉踏断来时路。\n疯癫汉，无字经，信口掉舌说不尽，海底金乌天上日，目中童子眼前人。\n觉即了，不施功，物我俱亡心境空，菡萏枝枝撑夜月，木犀夜夜扇香风。\n有人等，寻经论，终年求解不起行，分别名相那知休，入海算沙徒自辛。\n佛当日，曾叮咛，数他珍宝无己分，从来蹭瞪行不利，难免枉堕文字坑。\n亦愚痴，亦憨呆，海上蜃楼生实解，执指为月枉施功，根尘法中盲摩揣。\n心为根，境为尘，两种犹如镜上痕，痕垢尽净光始现，心境双亡性乃真。\n非不非，是不是，毫厘差之千里失，是即龙女顿成佛，非则善星人身失。\n种性邪，错知解，不达如来本性怀，二乘苦行非究竟，外道炼身终必坏。\n不思议，解脱力，恒沙大地载不起，摩诃般若波罗蜜，甚深般若波罗蜜。\n圆顿教，没人情，翻身踏倒涅槃城，威音那畔至今日，好个风流画不成！\n方便门，善巧开，火中生莲终不坏，勇施犯重悟无生，早已成佛无障碍。\n一切处，悉兰若，无闹无静无牵挂，怡然幽居无遮殿，游戏人间实潇洒。\n江照月，松风吹，更于何处觅作为，万世古今如电拂，三千刹海一芦苇。\n旃檀林，无杂树，郁密幽深狮子住，境静林间独自游，走兽飞禽皆远去。\n心境明，照无碍，廓然莹彻周法界，万象森罗隐现中，一颗圆明无内外。\n日可冷，月可热，邪见何能坏真说，无筋空力大无比，螳螂岂能拒车辙？\n如实唱，如实听，未曾开口已和竟，三世诸佛齐唱和，尽未来际无穷尽。\n歌毕不觉哈哈大笑，和者喝曰：不怕开了口合不得吗？诸人且道，这疯汉哈哈大笑，毕竟作么生？\n\n解脱歌作者：大愚法师', '2019-01-14 21:10:53');

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inventory_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `quantity` int(11) NULL DEFAULT NULL,
  `lock_quantity` int(11) NULL DEFAULT NULL,
  `expire_date` date NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1908 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inventory_log
-- ----------------------------
DROP TABLE IF EXISTS `inventory_log`;
CREATE TABLE `inventory_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `mark` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `indx`(`create_time`, `mark`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `owner_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warehouse_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2225 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `id_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'fleam', '123123', '王正东', 29, '111111111');

SET FOREIGN_KEY_CHECKS = 1;
