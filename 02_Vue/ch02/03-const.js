// 객체는 참조형 변수임.
const p1 = { name: 'john', age: 20 };

// 참조형 변수의 경우 내부 필드 값은 변경 가능
p1.age = 22;
console.log(p1);

// const로 선언했기 때문에 참조하는 객체 자체를 변경하는 것은 불가능.
// p1 = { name: 'lee', age: 22 }; -> TypeError
