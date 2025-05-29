// < 구조분해 할당 >
// 1. 배열
let arr = [10, 20, 30, 40];
// 받아올 때 개수 불일치해도 상관 없음
let [a1, a2, a3] = arr;
console.log(a1, a2, a3);

// 2. 객체
let p1 = { name: '홍길동', age: 20, gender: 'M' };
let { name: n, age: a, gender } = p1; // : 으로 변수명 변경 가능
// key값을 입력하면, value가 출력됨.
console.log(n, a, gender);
