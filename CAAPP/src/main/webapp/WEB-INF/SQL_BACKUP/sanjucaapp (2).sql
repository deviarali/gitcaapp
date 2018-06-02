-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2018 at 11:35 PM
-- Server version: 5.5.24
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sanjucaapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `applicationuser`
--

CREATE TABLE IF NOT EXISTS `applicationuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdate` datetime NOT NULL,
  `isactive` bit(1) NOT NULL,
  `loginattempts` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `applicationuser`
--

INSERT INTO `applicationuser` (`id`, `createdate`, `isactive`, `loginattempts`, `password`, `username`) VALUES
(1, '2018-01-07 00:05:00', b'1', 0, '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `client_id` int(10) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(50) DEFAULT NULL,
  `trade_name` varchar(50) DEFAULT NULL,
  `client_mobile` varchar(13) DEFAULT NULL,
  `client_email` varchar(35) DEFAULT NULL,
  `pan_number` varchar(15) DEFAULT NULL,
  `aadhar_number` varchar(16) DEFAULT NULL,
  `gst_number` varchar(15) DEFAULT NULL,
  `tan_number` varchar(35) DEFAULT NULL,
  `account_details` varchar(55) DEFAULT NULL,
  `client_esi` varchar(15) DEFAULT NULL,
  `client_epf` varchar(15) DEFAULT NULL,
  `client_se` varchar(15) DEFAULT NULL,
  `client_created_date` date DEFAULT NULL,
  `client_type_id` int(11) DEFAULT NULL,
  `company_status_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  KEY `FK_98f1nk912y0qqjmg8tvns7hj6` (`client_type_id`),
  KEY `FK_q72btrvkltnwmkk8il2uapa3v` (`company_status_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`client_id`, `client_name`, `trade_name`, `client_mobile`, `client_email`, `pan_number`, `aadhar_number`, `gst_number`, `tan_number`, `account_details`, `client_esi`, `client_epf`, `client_se`, `client_created_date`, `client_type_id`, `company_status_id`) VALUES
(1, 'gggg', 'gggg', 'ggggg', 'g', 'ggggg', 'g', 'gg', 'ggg', 'ggg', 'ggg', 'ggg', 'g', '2018-05-18', 1, 1),
(2, 'Ganesh', 'ggggg', '55555', 'g@g.com', 'ggggg', 'ggggg', 'ggggg', 'ggggg', 'ggggg', 'ggggg', 'ggggg', 'ggggg', '2018-05-19', 1, 3),
(3, 'sharan', '1', '99999999', 'sharan@gmail.com', '123', '123', '123', '12', '12', '123', '123', '123', '2018-05-28', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `client_nature_of_assignment`
--

CREATE TABLE IF NOT EXISTS `client_nature_of_assignment` (
  `nature_id` int(11) NOT NULL AUTO_INCREMENT,
  `nature_of_assignment_createddate` datetime DEFAULT NULL,
  `nature_status` varchar(255) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `nature_of_assignment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`nature_id`),
  KEY `FK_55vncfech2y1vlbhpeutc404b` (`client_id`),
  KEY `FK_oc9uuespoch16ex1item7vvv1` (`nature_of_assignment_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `client_nature_of_assignment`
--

INSERT INTO `client_nature_of_assignment` (`nature_id`, `nature_of_assignment_createddate`, `nature_status`, `client_id`, `nature_of_assignment_id`) VALUES
(1, '2018-05-28 17:30:30', 'CREATED', 3, 2),
(2, '2018-05-28 17:30:30', 'CREATED', 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `client_type`
--

CREATE TABLE IF NOT EXISTS `client_type` (
  `client_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_type_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `client_type`
--

INSERT INTO `client_type` (`client_type_id`, `client_type_name`) VALUES
(1, 'Regular client'),
(2, 'Annual client');

-- --------------------------------------------------------

--
-- Table structure for table `company_status`
--

CREATE TABLE IF NOT EXISTS `company_status` (
  `company_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`company_status_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `company_status`
--

INSERT INTO `company_status` (`company_status_id`, `company_status_name`) VALUES
(1, 'Indidusual'),
(2, 'Firm'),
(3, 'Comp');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` int(5) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(35) DEFAULT NULL,
  `employee_address` varchar(255) DEFAULT NULL,
  `employee_mobile` varchar(13) DEFAULT NULL,
  `employee_email` varchar(35) DEFAULT NULL,
  `employee_pan` varchar(15) DEFAULT NULL,
  `employee_aadhar` varchar(16) DEFAULT NULL,
  `employee_parent_address` varchar(255) DEFAULT NULL,
  `employee_status` varchar(10) DEFAULT NULL,
  `employee_createddate` date DEFAULT NULL,
  `employee_doj` date DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_name`, `employee_address`, `employee_mobile`, `employee_email`, `employee_pan`, `employee_aadhar`, `employee_parent_address`, `employee_status`, `employee_createddate`, `employee_doj`) VALUES
(1, 'Ganesh', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Shivappa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Ganesh', 'Gadag', '9945961063', 'ganid005@gmail.com', '55555', '55555', 'Bangalore', 'ACTIVE', NULL, '2018-05-21'),
(4, 'Neelanagouda', 'Goralli', '7795259974', 'goudatceise@gmail.com', 'ggggg', 'ggggg', 'ggggg', 'ACTIVE', NULL, '2018-05-21'),
(5, 'Shivappa', 'Bagalkot', '7676060664', 's.raaj46@gmail.com', 'ggggg', 'ggggg', 'Bangalore', 'ACTIVE', NULL, '2018-05-21'),
(6, 'G', 's', '55555', 'g@g.com', 'g', 'g', 'g', 'ACTIVE', NULL, '2018-05-21'),
(7, 'g', 'g', '555', 'ggggg', 'g', 'gg', 'g', 'ACTIVE', NULL, '2018-05-21');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `nature_of_assignment`
--

CREATE TABLE IF NOT EXISTS `nature_of_assignment` (
  `nature_of_assignment_id` int(10) NOT NULL AUTO_INCREMENT,
  `nature_of_assignment_name` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`nature_of_assignment_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `nature_of_assignment`
--

INSERT INTO `nature_of_assignment` (`nature_of_assignment_id`, `nature_of_assignment_name`) VALUES
(1, 'GST'),
(2, 'ESI'),
(3, 'EPF'),
(4, 'PT-FILING'),
(5, 'ETDS RETURN');

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE IF NOT EXISTS `tasks` (
  `task_id` int(15) NOT NULL AUTO_INCREMENT,
  `client_id` int(10) DEFAULT NULL,
  `nature_of_assignment_id` int(10) DEFAULT NULL,
  `employee_task_remarks` varchar(500) DEFAULT NULL,
  `admin_task_remark` varchar(100) DEFAULT NULL,
  `verify_by` int(10) DEFAULT NULL,
  `task_assignee_id` int(10) DEFAULT NULL,
  `task_created_date` date DEFAULT NULL,
  `task_start_date` date DEFAULT NULL,
  `task_status_id` int(5) DEFAULT NULL,
  `prioritystatus` varchar(45) DEFAULT NULL,
  `tasktatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`task_id`) USING BTREE,
  KEY `client_id_fk_tasks` (`client_id`),
  KEY `nature_of_assignment_id_fk_tasks` (`nature_of_assignment_id`),
  KEY `verify_by_fk_tasks` (`verify_by`),
  KEY `task_assignee_id_fk_tasks` (`task_assignee_id`),
  KEY `task_status_id_fk_tasks` (`task_status_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`task_id`, `client_id`, `nature_of_assignment_id`, `employee_task_remarks`, `admin_task_remark`, `verify_by`, `task_assignee_id`, `task_created_date`, `task_start_date`, `task_status_id`, `prioritystatus`, `tasktatus`) VALUES
(2, 3, 4, NULL, NULL, NULL, 1, '2018-06-03', '2018-01-04', 1, 'LOW', 'PARTIALLY_COMPLETED');

-- --------------------------------------------------------

--
-- Table structure for table `task_status`
--

CREATE TABLE IF NOT EXISTS `task_status` (
  `task_status_id` int(5) NOT NULL AUTO_INCREMENT,
  `task_status_name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`task_status_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `task_status`
--

INSERT INTO `task_status` (`task_status_id`, `task_status_name`) VALUES
(1, 'STARTED'),
(2, 'IN_PROGRESS'),
(3, 'COMPLETED');

-- --------------------------------------------------------

--
-- Table structure for table `temp`
--

CREATE TABLE IF NOT EXISTS `temp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `userrole`
--

CREATE TABLE IF NOT EXISTS `userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `userrole`
--

INSERT INTO `userrole` (`id`, `rolename`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `userroles`
--

CREATE TABLE IF NOT EXISTS `userroles` (
  `applicationuser_id` int(11) NOT NULL,
  `userrole_id` int(11) NOT NULL,
  PRIMARY KEY (`applicationuser_id`,`userrole_id`),
  KEY `FK_lqysox5l4np0hoxivejeqk2xo` (`userrole_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userroles`
--

INSERT INTO `userroles` (`applicationuser_id`, `userrole_id`) VALUES
(1, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `client_nature_of_assignment`
--
ALTER TABLE `client_nature_of_assignment`
  ADD CONSTRAINT `FK_55vncfech2y1vlbhpeutc404b` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  ADD CONSTRAINT `FK_oc9uuespoch16ex1item7vvv1` FOREIGN KEY (`nature_of_assignment_id`) REFERENCES `nature_of_assignment` (`nature_of_assignment_id`);

--
-- Constraints for table `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `client_id_fk_tasks` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  ADD CONSTRAINT `nature_of_assignment_id_fk_tasks` FOREIGN KEY (`nature_of_assignment_id`) REFERENCES `nature_of_assignment` (`nature_of_assignment_id`),
  ADD CONSTRAINT `task_assignee_id_fk_tasks` FOREIGN KEY (`task_assignee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `task_status_id_fk_tasks` FOREIGN KEY (`task_status_id`) REFERENCES `task_status` (`task_status_id`),
  ADD CONSTRAINT `verify_by_fk_tasks` FOREIGN KEY (`verify_by`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `userroles`
--
ALTER TABLE `userroles`
  ADD CONSTRAINT `FK_a76wu2uah316g0i2922he4lap` FOREIGN KEY (`applicationuser_id`) REFERENCES `applicationuser` (`id`),
  ADD CONSTRAINT `FK_lqysox5l4np0hoxivejeqk2xo` FOREIGN KEY (`userrole_id`) REFERENCES `userrole` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
