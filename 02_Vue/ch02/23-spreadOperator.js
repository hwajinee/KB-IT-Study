let obj1 = { name: '최화진', age: 27 };
let obj2 = obj1; // shallow copy ; 주소값을 복사하여 참조 객체를 공유함.
let obj3 = { ...obj1 }; //obj1의 값만 복사해서 새로운 객체를 생성한다. ... 으로 모든 데이터를 펼치고 {} 새로운 객체에 담았다고 생각하면 됨.
let obj4 = { ...obj1, email: 'hwajin@naver.com' }; // 값 복사 + 새로운 속성 추가

console.log(obj1 == obj2);
console.log(obj1 == obj3);

obj2.age = 19; // 같은 주소를 공유하므로, obj1의 age도 같이 변경됨.
console.log(obj2);
console.log(obj1);

obj3.age = 39; // obj3은 값만 복사한 것이므로, 속성값을 변경해도 obj1에 영향을 주지 않음.
console.log(obj3);
console.log(obj1);

let arr1 = [100, 200, 300];
// ... 연산자를 사용하여 arr1을 풀어서 삽입
let arr2 = ['hello', ...arr1, 'bye'];
console.log(arr1);
console.log(arr2);
