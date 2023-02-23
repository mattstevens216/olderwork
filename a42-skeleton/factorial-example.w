// modified from the old version to get rid of the (-1) 
var x = 1 + 4;
var acc = 1;
var y = 1;
while (y <= x)
{
  acc = acc * y;
  y = y + 1;
}
print "result is ";
print acc;
print "\n";
