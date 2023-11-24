-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: student_point_db
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8xgiqy8bjep4uq5h0h83cm358` (`student_id`),
  CONSTRAINT `FK8xgiqy8bjep4uq5h0h83cm358` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('e8f805e2-c04f-47de-b708-f87c6fb9f226','hoangxq01@gmail.com','$2a$10$ScfGrLXkx7ZZkzvtGpQHeuyu35TeANpk1YDXKHhq7Q/lEEcJfprS6','B19DCCN279','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester_of_students`
--

DROP TABLE IF EXISTS `semester_of_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semester_of_students` (
  `id` varchar(255) NOT NULL,
  `gpa` double NOT NULL,
  `semester_id` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj3wa53yolt46u3nl7isis1ds` (`semester_id`),
  KEY `FKd2ng66un946lb1fn3uv1qx7kh` (`student_id`),
  CONSTRAINT `FKd2ng66un946lb1fn3uv1qx7kh` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `FKj3wa53yolt46u3nl7isis1ds` FOREIGN KEY (`semester_id`) REFERENCES `semesters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester_of_students`
--

LOCK TABLES `semester_of_students` WRITE;
/*!40000 ALTER TABLE `semester_of_students` DISABLE KEYS */;
INSERT INTO `semester_of_students` VALUES ('10836b07-618e-42a7-9aa4-ab76263da6d0',3.225,'324475b9-6e53-4f0e-b62a-7a67541c0bec','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496'),('11fbe5aa-0157-485d-adff-64f25abd1a1e',2.8375,'9da3175a-c1a0-4b72-a812-cf058b19ca62','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496'),('23ec7278-ce72-42a9-810c-ed3707dd9d51',3.2,'326f3844-05a0-4e36-b935-e41344de0928','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496'),('635ac152-d523-430c-8d01-23ac074e6734',3.4166666666666665,'a75f647e-7151-40fb-8732-f22aedbc599e','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496'),('89606dc8-0503-4b30-80c5-3952d5361a0f',3,'87367bec-a597-41a6-aaf5-7f320ebfc2a7','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496'),('9276ffc1-bed7-4c0a-a6ee-9af10bd40a5a',3.0300000000000002,'62d73a4f-6177-4c5c-9f3a-82341ee9a074','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496'),('d260e7a9-115a-4879-8a57-fad9ca378a80',3.225925925925926,'e1fbf3d9-28d1-4ab6-baf7-b5a8f2a94c39','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496'),('e36b593e-7c26-4dec-bfde-57cf07ddae3d',3.2705882352941176,'27bb76d1-41df-4198-b5e4-42d592560de3','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496');
/*!40000 ALTER TABLE `semester_of_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semesters`
--

DROP TABLE IF EXISTS `semesters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semesters` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semesters`
--

LOCK TABLES `semesters` WRITE;
/*!40000 ALTER TABLE `semesters` DISABLE KEYS */;
INSERT INTO `semesters` VALUES ('27bb76d1-41df-4198-b5e4-42d592560de3','Học kỳ 2','Năm học 2020-2021'),('324475b9-6e53-4f0e-b62a-7a67541c0bec','Học kỳ 2','Năm học 2021-2022'),('326f3844-05a0-4e36-b935-e41344de0928','Học kỳ 1','Năm học 2020-2021'),('62d73a4f-6177-4c5c-9f3a-82341ee9a074','Học kỳ 1','Năm học 2022-2023'),('87367bec-a597-41a6-aaf5-7f320ebfc2a7','Học kỳ 2','Năm học 2022-2023'),('9da3175a-c1a0-4b72-a812-cf058b19ca62','Học kỳ 2','Năm học 2019-2020'),('a75f647e-7151-40fb-8732-f22aedbc599e','Học kỳ 1','Năm học 2021-2022'),('e1fbf3d9-28d1-4ab6-baf7-b5a8f2a94c39','Học kỳ 1','Năm học 2019-2020');
/*!40000 ALTER TABLE `semesters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int NOT NULL,
  `class_code` varchar(255) DEFAULT NULL,
  `cpa` double NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `student_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('2ed695d0-fbe0-47c7-b3f1-4917e3ce6496',NULL,0,'D19-HTTT01',3.173648648648649,'Nguyen Huy Hoang','B19DCCN279');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_of_students`
--

DROP TABLE IF EXISTS `subject_of_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_of_students` (
  `id` varchar(255) NOT NULL,
  `attendance_point` double DEFAULT NULL,
  `exam_point` double DEFAULT NULL,
  `final_point` double DEFAULT NULL,
  `gpa` double NOT NULL,
  `letter_grade` varchar(255) DEFAULT NULL,
  `practice_point` double DEFAULT NULL,
  `test_point` double DEFAULT NULL,
  `semester_student_id` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `subject_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpxgpfmq5j7nkutu53fxfy2itr` (`semester_student_id`),
  KEY `FKqu0h2plf4q209f47d53j79end` (`student_id`),
  KEY `FKkt2ddvhuywy0yvw6lxsb02l1l` (`subject_id`),
  CONSTRAINT `FKkt2ddvhuywy0yvw6lxsb02l1l` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`),
  CONSTRAINT `FKpxgpfmq5j7nkutu53fxfy2itr` FOREIGN KEY (`semester_student_id`) REFERENCES `semester_of_students` (`id`),
  CONSTRAINT `FKqu0h2plf4q209f47d53j79end` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_of_students`
--

LOCK TABLES `subject_of_students` WRITE;
/*!40000 ALTER TABLE `subject_of_students` DISABLE KEYS */;
INSERT INTO `subject_of_students` VALUES ('003239e0-74ee-4bf5-9183-cd38a3c9afe0',5.8,7.3,7.390000000000001,3,'B',7,8.8,'e36b593e-7c26-4dec-bfde-57cf07ddae3d','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','d50c1355-1f3f-4be9-8e37-ebc04283fa5f'),('0404bc2b-8dfd-4984-a6e1-733d7d42a5f4',9,7,7.4,3,'B',8,7,'11fbe5aa-0157-485d-adff-64f25abd1a1e','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','9bfc5365-5e21-4810-8b0f-8654d2fb8efe'),('07077eed-48db-489f-8fb6-ba0132e98fb0',10,7,7.800000000000001,3,'B',8,8.5,'635ac152-d523-430c-8d01-23ac074e6734','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','ec5c4bf2-f88b-47c3-921b-e8f1fa96f7ae'),('0b0ebfe7-dba5-437b-9311-85d9683374f9',10,10,9.6,4,'A+',8,10,'23ec7278-ce72-42a9-810c-ed3707dd9d51','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','5f56b1a4-fe26-48b0-8b80-ea163989e9ba'),('14edafdf-3d3b-482b-b68f-354a2319873c',9,7,7.4,3,'B',7.5,7.5,'9276ffc1-bed7-4c0a-a6ee-9af10bd40a5a','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','d54edda0-6954-4c36-bf52-831bc49553be'),('180af044-65ed-4bf5-9e4d-46085e3831b4',8,6,7.4,3,'B',8,10,'635ac152-d523-430c-8d01-23ac074e6734','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','124f7331-b168-412d-93c3-081f2a35e566'),('187baa7f-87f3-4cc2-9ab7-577d6dc314ed',8,8,8,3.5,'B+',8,8,'23ec7278-ce72-42a9-810c-ed3707dd9d51','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','9716e296-4f52-490c-a654-5fa4437028a9'),('1c0d507d-a5aa-426a-b6e7-1eb27c3e4391',9,5,5,1.5,'D+',4,4,'9276ffc1-bed7-4c0a-a6ee-9af10bd40a5a','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','43d0727a-487f-4683-a790-089ec959e890'),('1df0dc68-81d9-4473-8bb4-550608fb79e4',9,9.5,8.95,4,'A+',8,8.5,'23ec7278-ce72-42a9-810c-ed3707dd9d51','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','944ecfef-ded5-49cb-9a51-3576e978ec99'),('2458a900-cc4e-49ce-9119-7cc90a8fde0b',10,8,8.4,3.5,'B+',8,9,'11fbe5aa-0157-485d-adff-64f25abd1a1e','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','257bc953-44bc-4b0b-af71-492bc0569b6c'),('247c1bf8-f6e6-43b8-9130-e39d92ce62f1',8,8,8.1,3.5,'B+',8,8.5,'9276ffc1-bed7-4c0a-a6ee-9af10bd40a5a','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','dfabd7e6-d811-474f-8cb3-31c0951f101c'),('33b26b58-f3a7-40bc-ba96-94a43b33fd2d',8,8,8,3.5,'B+',8,8,'d260e7a9-115a-4879-8a57-fad9ca378a80','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','5d944724-e049-4d91-b2dc-44a0dd484937'),('34b1b2f9-e8f6-447a-aec2-1039640f46fa',8,8,7.7,3,'B',8.5,6,'e36b593e-7c26-4dec-bfde-57cf07ddae3d','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','ecc35270-2805-42f6-a159-60d0f067fe4b'),('364f06a9-7940-4a9f-a101-6f4265b1e684',7.5,8.5,8.4,3.5,'B+',10,7,'9276ffc1-bed7-4c0a-a6ee-9af10bd40a5a','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','6a47d47f-da84-4574-8897-10b672e8f87e'),('41ee851e-1e2c-45cd-a813-995ec8408a17',9,2,4.5,1,'D',8,5,'11fbe5aa-0157-485d-adff-64f25abd1a1e','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','96b6b27c-7de6-4c3b-aa5a-91466823358d'),('4381c561-0ef8-45fb-9963-68ebfaa1547a',10,9,9.1,4,'A+',8,10,'23ec7278-ce72-42a9-810c-ed3707dd9d51','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','ae22e4ea-4c1b-44f5-b627-ae09681b521b'),('46de238e-ac23-4a39-84ba-b52a43bd371b',9,7,7.6,3,'B',8,8,'635ac152-d523-430c-8d01-23ac074e6734','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','49ef05b0-dd32-4fff-8503-2356cd581a69'),('48a204b8-004c-41fe-b217-b4a790b776ac',10,6,7.2,3,'B',8,8,'23ec7278-ce72-42a9-810c-ed3707dd9d51','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','9e028e1f-6ce6-4de0-98af-9e1019db7c22'),('48cdc2b8-4ddc-4ef0-b755-46d958614c35',10,8.5,8.85,3.7,'A',8,10,'e36b593e-7c26-4dec-bfde-57cf07ddae3d','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','001e51dc-eabd-49a4-bea3-39de1cbe2b1e'),('5303e633-f6d9-4eff-9900-51f4d9a5349c',10,8,8.2,3.5,'B+',9,7,'d260e7a9-115a-4879-8a57-fad9ca378a80','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','22e07282-d511-40a2-b8d5-3ce7a45cf299'),('5c8b0f80-a2da-441b-85f6-5ceff50b251c',8,7,7.2,3,'B',7,7.5,'635ac152-d523-430c-8d01-23ac074e6734','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','7ea20163-9763-4fb6-90c8-2d9518de86bb'),('5eb59897-7da4-45e3-bee5-9618b5b04830',10,6.5,7.550000000000001,3,'B',8,8.5,'10836b07-618e-42a7-9aa4-ab76263da6d0','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','576548f8-3531-4556-99a7-82951b60f3f1'),('61186c6e-c9d7-46cb-a8d6-afa337a3867b',10,9,9.3,4,'A+',9.5,9.5,'635ac152-d523-430c-8d01-23ac074e6734','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','bb7f0389-fb85-4f17-a78b-80a81c26796a'),('6798ab92-e048-4f73-b0ae-6245dea59455',10,9,8.7,3.7,'A',9,7,'11fbe5aa-0157-485d-adff-64f25abd1a1e','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','5841ee33-8b87-4acc-b806-4bea5d62ce72'),('6a38658e-eef5-44a2-8cf3-d7556cb84386',8,2,3.6,1,'F',4,5,'d260e7a9-115a-4879-8a57-fad9ca378a80','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','e591d0fe-2628-4340-bef6-f1b248c9019f'),('6d1df110-bf97-4f43-a114-1a158c613ebe',7,7,7.36,3,'B',8,7.8,'89606dc8-0503-4b30-80c5-3952d5361a0f','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','b5a7b83f-db9c-4593-8243-5d79fc983251'),('6fb29a30-c43f-4711-9ec5-8729ff587abe',8,6.1,5.75,2,'C',3.5,6,'11fbe5aa-0157-485d-adff-64f25abd1a1e','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','c017f3bd-229b-4c0c-9501-f652d3adcdc5'),('8473779f-6231-43d4-a584-9f51586cea65',10,6.3,7.550000000000001,3,'B',8,9,'e36b593e-7c26-4dec-bfde-57cf07ddae3d','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','ec7f890d-18c8-4ace-b616-ced03b08bd7c'),('8a068d0b-cb5a-453f-b79a-9e9555d90daf',9,4.2,6.460000000000001,2.5,'C+',8.8,8.5,'10836b07-618e-42a7-9aa4-ab76263da6d0','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','15d1bef2-3996-4447-94eb-38775a41113a'),('8f0051ea-2d51-4af1-9901-2b50540415b1',8,7,7.5,3,'B',8,8,'89606dc8-0503-4b30-80c5-3952d5361a0f','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','85dab477-c62d-4dfe-8c4a-136f8d751169'),('8f4a6d36-33ea-403b-aacc-29a077a9934c',10,6,7.6,3,'B',8,10,'e36b593e-7c26-4dec-bfde-57cf07ddae3d','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','1481fb79-5ee2-491f-8698-717a44d62a14'),('8fca206a-9823-44b9-8c62-51246af26f67',8,8,8,3.5,'B+',8,8,'d260e7a9-115a-4879-8a57-fad9ca378a80','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','5d944724-e049-4d91-b2dc-44a0dd484937'),('a61e4b7e-cb4d-41b4-921b-7a6d4fe6e79b',10,8.5,7.85,3,'B',8,5,'9276ffc1-bed7-4c0a-a6ee-9af10bd40a5a','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','fd958221-0ab0-4268-adc7-1a0f75eb6699'),('a752811b-0d94-4159-9f88-051df75f3881',10,9,8.620000000000001,3.7,'A',8.6,7,'9276ffc1-bed7-4c0a-a6ee-9af10bd40a5a','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','d9dcad8f-8187-4175-8d30-4d0b532e208f'),('b0f58b55-1126-47f2-a739-5b149b7d9261',10,8,8.4,3.5,'B+',8,9,'d260e7a9-115a-4879-8a57-fad9ca378a80','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','be015355-af56-422e-a4d1-9f7fa79dd6d2'),('b0ffc673-7c2a-4ff4-ae3f-96174e28bbfc',9,9,8.2,3.5,'B+',8,6,'10836b07-618e-42a7-9aa4-ab76263da6d0','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','b9d9e934-908a-40ad-a7c3-1334bb26f131'),('b42a0c93-6259-4a2f-a4db-1ec8ec6936fc',6,7,7,3,'B',7.5,7,'9276ffc1-bed7-4c0a-a6ee-9af10bd40a5a','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','ce1d8041-bff3-493c-accf-3915f54d7826'),('ba4c8b1b-51f9-4eee-8806-656a88636542',9,10,9.2,4,'A+',8,8.5,'635ac152-d523-430c-8d01-23ac074e6734','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','e1200a78-632c-48bc-9e54-df6ed709357f'),('bc333691-850c-4f0f-bf25-a958710eb3e0',10,9.5,9.55,4,'A+',10,9,'11fbe5aa-0157-485d-adff-64f25abd1a1e','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','1d1f6def-62fb-4987-8258-ae51d9fac622'),('bcbe309b-23c5-4c23-b4ff-6e63aec7d9c8',8,8,8,3.5,'B+',8,8,'23ec7278-ce72-42a9-810c-ed3707dd9d51','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','9716e296-4f52-490c-a654-5fa4437028a9'),('c3c6ce19-b6b3-40c0-a2ea-6c07650c2110',9,6,6.7,2.5,'C+',8,6,'11fbe5aa-0157-485d-adff-64f25abd1a1e','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','049e6cdc-299b-4d5e-9e4a-b5b371813624'),('c75a279f-7de8-4e2d-9a24-24b2f57aca51',8,10,9.100000000000001,4,'A+',7,9.5,'10836b07-618e-42a7-9aa4-ab76263da6d0','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','38fc2376-7b62-4611-b9e5-63827db0fb5c'),('d1d3e167-3ef0-4f15-9555-259a0b77d38b',8,7,7.300000000000001,3,'B',8,7,'10836b07-618e-42a7-9aa4-ab76263da6d0','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','49d20c92-78d3-4d11-9557-dbfb85f78746'),('d3e25fc0-92ef-4e0c-b55a-659ef9bbd03e',10,4,5.8,2,'C',9,5,'d260e7a9-115a-4879-8a57-fad9ca378a80','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','2fc590a3-b13d-479c-866e-bdfcdee15282'),('dc456e80-33a2-4989-9a0f-0fcb7aa5f6dc',9,7.4,7.300000000000001,3,'B',6.5,7,'10836b07-618e-42a7-9aa4-ab76263da6d0','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','7ecdaf1d-063c-4aad-9b1a-d2770e0e394a'),('ddcb6dbd-3b98-489a-8ac4-c106e88cee3b',10,9.5,9.45,4,'A+',8.5,10,'e36b593e-7c26-4dec-bfde-57cf07ddae3d','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','abf9ca96-7abe-45a1-8932-74cfebf869d9'),('e2eb5808-b497-452f-89b4-3ac98ef5b6e2',8,8.3,8.15,3.5,'B+',8,8,'635ac152-d523-430c-8d01-23ac074e6734','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','048ed2fd-ede0-4c66-acf4-d8c2ed00aea9'),('e5ec04f5-8b9c-4362-a5dd-161e03ba5147',9,6,6.7,2.5,'C+',8,6,'e36b593e-7c26-4dec-bfde-57cf07ddae3d','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','6642cd99-4710-49a9-8a81-34fb67a75b63'),('f51c81a6-37a3-4bc1-85ce-1690b86e9ff9',9,9.5,8.05,3.5,'B+',7,5,'10836b07-618e-42a7-9aa4-ab76263da6d0','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','7b5f18c7-e817-44e0-a359-96a92e8c767b'),('f61497fc-032f-4883-b896-41c3c6898e78',10,10,8.8,3.7,'A',8,6,'d260e7a9-115a-4879-8a57-fad9ca378a80','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','cb5e0257-a478-4697-b7a7-49f1a4c693e4'),('f7951114-2b33-430b-954b-12c36d4e6c50',7,5.6,5.5,2,'C',6,4,'23ec7278-ce72-42a9-810c-ed3707dd9d51','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','9eeccb74-d2c5-40c3-a4e7-db6c3afaf9ff'),('fc04b409-f808-428f-8195-d788dc54ac59',6,2,4.7,1,'D',8,7.5,'23ec7278-ce72-42a9-810c-ed3707dd9d51','2ed695d0-fbe0-47c7-b3f1-4917e3ce6496','ec5c4bf2-f88b-47c3-921b-e8f1fa96f7ae');
/*!40000 ALTER TABLE `subject_of_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `id` varchar(255) NOT NULL,
  `credit` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `subject_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subject_code_UNIQUE` (`subject_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES ('001e51dc-eabd-49a4-bea3-39de1cbe2b1e',3,'Cấu trúc dữ liệu và giải thuật','INT1306'),('048ed2fd-ede0-4c66-acf4-d8c2ed00aea9',3,'Kiến trúc máy tính','INT13145'),('049e6cdc-299b-4d5e-9e4a-b5b371813624',2,'Chủ nghĩa xã hội khoa học','BAS1152'),('124f7331-b168-412d-93c3-081f2a35e566',3,'Hệ điều hành','INT1319'),('1481fb79-5ee2-491f-8698-717a44d62a14',2,'Lịch sử Đảng cộng sản Việt Nam','BAS1153'),('15d1bef2-3996-4447-94eb-38775a41113a',3,'Cơ sở dữ liệu phân tán','INT14148'),('1d1f6def-62fb-4987-8258-ae51d9fac622',3,'Giải tích 2','BAS1204'),('22e07282-d511-40a2-b8d5-3ce7a45cf299',3,'Giải tích 1','BAS1203'),('257bc953-44bc-4b0b-af71-492bc0569b6c',2,'Xác suất thống kê','BAS1226'),('2fc590a3-b13d-479c-866e-bdfcdee15282',2,'Tin học cơ sở 1','INT1154'),('38fc2376-7b62-4611-b9e5-63827db0fb5c',3,'Nhập môn trí tuệ nhân tạo','INT1341'),('43d0727a-487f-4683-a790-089ec959e890',3,'Các hệ thống dựa trên tri thức','INT1404'),('49d20c92-78d3-4d11-9557-dbfb85f78746',1,'Kỹ năng làm việc nhóm','SKD1102'),('49ef05b0-dd32-4fff-8503-2356cd581a69',1,'Kỹ năng thuyết trình','SKD1101'),('576548f8-3531-4556-99a7-82951b60f3f1',3,'Lập trình với Python','INT13162'),('5841ee33-8b87-4acc-b806-4bea5d62ce72',2,'Tin học cơ sở 2','INT1155'),('5d944724-e049-4d91-b2dc-44a0dd484937',7,'Giáo dục quốc phòng','BAS1105M'),('5f56b1a4-fe26-48b0-8b80-ea163989e9ba',4,'Vật lý 1 và thí nghiệm','BAS1224'),('6642cd99-4710-49a9-8a81-34fb67a75b63',1,'Kỹ năng tạo lập Văn bản','SKD1103'),('6a47d47f-da84-4574-8897-10b672e8f87e',3,'An toàn và bảo mật hệ thống thông tin','INT1303'),('7b5f18c7-e817-44e0-a359-96a92e8c767b',3,'Nhập môn công nghệ phần mềm','INT1340'),('7ea20163-9763-4fb6-90c8-2d9518de86bb',3,'Mạng máy tính','INT1336'),('7ecdaf1d-063c-4aad-9b1a-d2770e0e394a',4,'Tiếng Anh A22','BAS1144'),('85dab477-c62d-4dfe-8c4a-136f8d751169',2,'Quản lý dự án phần mềm','INT1450'),('944ecfef-ded5-49cb-9a51-3576e978ec99',2,'Kỹ thuật số','ELE1433'),('96b6b27c-7de6-4c3b-aa5a-91466823358d',2,'Giáo dục thể chất 2','BAS1107'),('9716e296-4f52-490c-a654-5fa4437028a9',3,'Ngôn ngữ lập trình C++','INT1339'),('9bfc5365-5e21-4810-8b0f-8654d2fb8efe',2,'Kinh tế chính trị Mác- Lênin','BAS1151'),('9e028e1f-6ce6-4de0-98af-9e1019db7c22',3,'Toán rời rạc 1','INT1358'),('9eeccb74-d2c5-40c3-a4e7-db6c3afaf9ff',4,'Tiếng Anh A12','BAS1142'),('abf9ca96-7abe-45a1-8932-74cfebf869d9',3,'Toán rời rạc 2','INT1359'),('ae22e4ea-4c1b-44f5-b627-ae09681b521b',4,'Vật lý 3 và thí nghiệm','BAS1227'),('b5a7b83f-db9c-4593-8243-5d79fc983251',3,'Nhập môn khoa học dữ liệu','INT14150'),('b9d9e934-908a-40ad-a7c3-1334bb26f131',3,'Thực tập cơ sở','INT13147'),('bb7f0389-fb85-4f17-a78b-80a81c26796a',3,'Cơ sở dữ liệu','INT1313'),('be015355-af56-422e-a4d1-9f7fa79dd6d2',3,'Triết học Mác - Lênin','BAS1150'),('c017f3bd-229b-4c0c-9501-f652d3adcdc5',3,'Tiếng Anh A11','BAS1141'),('cb5e0257-a478-4697-b7a7-49f1a4c693e4',3,'Đại số','BAS1201'),('ce1d8041-bff3-493c-accf-3915f54d7826',2,'Phương pháp luận nghiên cứu khoa học','SKD1108'),('d50c1355-1f3f-4be9-8e37-ebc04283fa5f',3,'Tiếng Anh A21','BAS1143'),('d54edda0-6954-4c36-bf52-831bc49553be',3,'Phân tích và thiết kế hệ thống thông tin','INT1342M'),('d9dcad8f-8187-4175-8d30-4d0b532e208f',3,'IoT và ứng dụng','INT14149'),('dfabd7e6-d811-474f-8cb3-31c0951f101c',3,'Xử lý ảnh','INT13146'),('e1200a78-632c-48bc-9e54-df6ed709357f',3,'Lập trình hướng đối tượng','INT1332'),('e591d0fe-2628-4340-bef6-f1b248c9019f',2,'Giáo dục thể chất 1','BAS1106'),('ec5c4bf2-f88b-47c3-921b-e8f1fa96f7ae',2,'Tư tưởng Hồ Chí Minh','BAS1122'),('ec7f890d-18c8-4ace-b616-ced03b08bd7c',2,'Xử lý tín hiệu số','ELE1330'),('ecc35270-2805-42f6-a159-60d0f067fe4b',3,'Lý thuyết thông tin','ELE1319'),('fd958221-0ab0-4268-adc7-1a0f75eb6699',3,'Lập trình Web','INT1434');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-15 12:03:54
