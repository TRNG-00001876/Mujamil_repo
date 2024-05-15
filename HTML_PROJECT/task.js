// Write a simple JavaScript program to join all elements of the following array into a string.

const array = ['Hello', 'world', '!'];
const joinedString = array.join(' ');

console.log(joinedString);

// Write a JavaScript program to compute the sum and product of an array of integers.

function Sum(array) {
    let sum = 0;
    let product = 1;

    for (let i = 0; i < array.length; i++) {
        sum += array[i];
        product *= array[i];
    }

    return { sum, product };
}

const integers = [1, 2, 3, 4, 5];
const { sum, product } = Sum(integers);

console.log("Sum:", sum);
console.log("Product:", product);

// Write a JavaScript program that accepts a number as input and inserts dashes (-) between each even number. For example if you accept 025468 the output should be 0-254-6-8.

function Dashes(number) {
    const digits = number.toString().split('');
    let result = '';

    for (let i = 0; i < digits.length; i++) {
        const currentDigit = parseInt(digits[i], 10);
        const nextDigit = parseInt(digits[i + 1], 10);

        result += currentDigit;

        if (currentDigit % 2 === 0 && nextDigit % 2 === 0) {
            result += '-';
        }
    }

    return result;
}

const inputNumber = 254068;
const result = Dashes(inputNumber);
console.log(result);


let arr=[10,20,30];
let copy=arr;
console.log(arr);
console.log(copy);

copy[1]=10000;

console.log(arr);
console.log(copy);

let ar = new Array[10,20,30,40];
let copies=ar;
console.log(ar);
console.log(copies);

copies[2]=1000;

console.log(ar);
console.log(copies);
