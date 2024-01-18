<?php
$temp = "The date is ";
echo $temp.longdate($temp, time());

function longdate($text, $timestamp)
{
    return $text. date ("l F jS Y", $timestamp);
}
?>