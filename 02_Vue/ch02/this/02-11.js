let obj = { result: 0 };
obj.add = function (x, y) {
  this.result = x + y;
};

let add2 = obj.add;

console.log(add2 == obj.add); // true, 동일한 함수. 참조가 동일한 것

// obj.add와 다르게 this가 탑 레벨인 윈도우(전역객체)를 가리킴.
// 호출하는 곳이 전역이기 때문에 전역 범위에 result가 생성됨.
add2(3, 4);
console.log(obj);
console.log(result);
