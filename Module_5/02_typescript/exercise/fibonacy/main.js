var sum = 0;
var size = 5;
function calFibonacci(num) {
    if (num == 0) {
        return 0;
    }
    if (num == 1) {
        return 1;
    }
    return calFibonacci(num - 1) + calFibonacci(num - 2);
}
var arr = [];
for (var i = 0; i < size; i++) {
    arr.push(calFibonacci(i));
    sum += calFibonacci(i);
}
console.log(arr);
console.log(sum);
