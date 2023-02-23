var x = True;
var y = False;
var z = True;
var w = 1;
if (x && y || z){
   y = True;
}
while(y){
   if (w == 5){
      y = False;
   }
   else w = w+1;
}
print "result is ";
print w;
print "\n";