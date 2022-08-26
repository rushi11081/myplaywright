console.log("hello world");
var marks=[12,34,45,66]
var sum=0
for(var i=0;i<marks.length;i++)
{
 sum=sum+marks[i]
}
console.log(sum)

var toatl =marks.reduce((sum,marks)=>sum+marks,0)
console.log(toatl)

var even=marks.filter(marks=>marks%2==0)
console.log(even)

var num=marks.map(marks=>marks*2)
console.log(num)