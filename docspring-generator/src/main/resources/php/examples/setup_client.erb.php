<?php
$docspring = new \DocSpring\Client();
$docspring->getConfig()
  ->setUsername("<%= @api_token_id %>")
  ->setPassword("<%= @api_token_secret %>");
