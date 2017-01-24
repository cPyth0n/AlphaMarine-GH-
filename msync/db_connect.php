<?php

//Getting dB Configurations
require 'config.php';

//Connection Variables to the dBase_backEnd
$connect = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD) or die('Unable to Connect Server');

//Making Connection and Selecting a dB
mysqli_select_db($connect, DB_DATABASE) or die('Unable to Locate database');





























