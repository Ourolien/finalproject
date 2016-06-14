-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2016 at 05:43 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `onlineshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `Product ID` varchar(10) NOT NULL,
  `Manufacturer` varchar(10) NOT NULL,
  `Price` varchar(10) NOT NULL,
  `Stock` int(10) NOT NULL,
  `Product Name` varchar(10) NOT NULL,
  `Wish ID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `username` varchar(20) NOT NULL,
  `customerEmail` varchar(25) NOT NULL,
  `name` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `phone` varchar(12) NOT NULL,
  `address` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`username`, `customerEmail`, `name`, `dob`, `phone`, `address`, `password`) VALUES
('mike', 'mike@gmail.com', 'mike', '1990-01-01', '324324', 'adfe2qwf', 'mike');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `paymentCode` char(6) NOT NULL,
  `transactionCode` char(6) NOT NULL,
  `amountPaid` double NOT NULL,
  `paymentDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productID` char(6) NOT NULL,
  `manufacturer` varchar(20) NOT NULL,
  `price` varchar(10) NOT NULL,
  `stock` int(10) NOT NULL,
  `productname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `manufacturer`, `price`, `stock`, `productname`) VALUES
('001', 'sony', '50', 5, 'ps4'),
('007', 'sega', '50', 5, 'dreamcast');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `reviewID` char(6) NOT NULL,
  `productID` char(6) NOT NULL,
  `username` varchar(20) NOT NULL,
  `rating` int(1) NOT NULL,
  `comment` varchar(200) NOT NULL,
  `reviewDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `shippingdetail`
--

CREATE TABLE `shippingdetail` (
  `shippingCode` char(6) NOT NULL,
  `paymentCode` char(6) NOT NULL,
  `Type` varchar(7) NOT NULL,
  `shippingDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionCode` char(6) NOT NULL,
  `username` varchar(20) NOT NULL,
  `transactionDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transactiondetail`
--

CREATE TABLE `transactiondetail` (
  `transactionCode` char(6) NOT NULL,
  `productID` char(6) NOT NULL,
  `Qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactiondetail`
--

INSERT INTO `transactiondetail` (`transactionCode`, `productID`, `Qty`) VALUES
('', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `wishlist`
--

CREATE TABLE `wishlist` (
  `wishID` char(6) NOT NULL,
  `username` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `wishlistitemdetail`
--

CREATE TABLE `wishlistitemdetail` (
  `wishID` char(6) NOT NULL,
  `productID` char(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`Wish ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`paymentCode`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`reviewID`);

--
-- Indexes for table `shippingdetail`
--
ALTER TABLE `shippingdetail`
  ADD PRIMARY KEY (`shippingCode`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionCode`);

--
-- Indexes for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`wishID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
