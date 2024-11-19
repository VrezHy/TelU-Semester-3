<?php
require 'config.php'; 
$dsn = "mysql:host=".DB_HOST.";dbname=".DB_NAME.";charset=UTF8";
try {
  $pdo = new PDO($dsn, DB_USER, DB_PWD);
} catch (PDOException $e) {
  echo $e->getMessage();
}
?>