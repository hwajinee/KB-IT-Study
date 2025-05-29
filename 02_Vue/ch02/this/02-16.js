// 객체 리터럴 - 1

let name = '홍길동';
let age = 20;
let email = 'gdhong@test.com';

// let obj = { name: name, age: age, email: email };
// 변수명이 객체의 속성명과 일치하는 경우, 중복 제거 가능
let obj = { name, age, email };
console.log(obj);
