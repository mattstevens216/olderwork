#!/usr/bin/perl
# a sample testw script that runs on Mac (Unix-like OS)
# written by Hyunyoung Lee for Students in CSCE 314 Sections 501, 201
# Students: you need to create your own test input .w programs
#    at least ten of them, excluding the three already provided: 
#    empty-example.w, factorial-example.w, and factorial-wrong.w
 
$tested = 0; $succeeded = 0; $failed = 0; $intentional_error = 0;
 
# test case 1 (empty-example.w) should succeed
$tested += 1;
$output = `./w empty-example.w`;
if( $output eq "Testing...\n" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# test case 2 (factorial-example.w) should succeed
$tested += 1;
$output = `./w factorial-example.w`;
if( $output eq "result is 120\n" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# test case 3 (factorial-wrong.w) is for intentional error
$tested += 1;
$output = `./w factorial-wrong.w 2>&1`;
@words = split " ", $output;
if( ($words[1] eq "Unused") && ($words[4] eq "while")) {
   $intentional_error += 1;
}else{
   $failed += 1;
}
# add more test cases of yours ...

# your own test case 1
$tested += 1;
$output = `./w ex1.w`;
if( $output eq "result is 16" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# your own test case 2
$tested += 1;
$output = `./w ex2.w`;
if( $output eq "result is 30" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# your own test case 3
$tested += 1;
$output = `./w ex3.w`;
if( $output eq "result is 100" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# your own test case 4 $tested += 1;
$output = `./w ex4.w`;
if( $output eq "result is 16" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}

# your own test case 5
$tested += 1;
$output = `./w ex5.w`;
if( $output eq "result is True" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# your own test case 6
$tested += 1;
$output = `./w ex6.w`;
if( $output eq "result is 10" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# your own test case 7
$tested += 1;
$output = `./w ex7.w`;
if( $output eq "result is 4" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# your own test case 8
$tested += 1;
$output = `./w ex8.w`;
if( $output eq "result is 59049" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# your own test case 9
$tested += 1;
$output = `./w ex9.w`;
if( $output eq "result is 8" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
# your own test case 10
$tested += 1;
$output = `./w ex10.w`;
if( $output eq "result is 5" ) {
   $succeeded += 1;
}else{
   $failed += 1;
}
print "$tested tested\n";
print "$succeeded (succeeded) + $intentional_error (intended error) passed\n";
print "$failed failed\n";
 
# to run this script, type the following at the terminal command line prompt
# > perl testw.unix.pl
# then the result should be the following three lines
# 3 tested
# 2 (succeeded) + 1 (intended error) passed
# 0 failed

