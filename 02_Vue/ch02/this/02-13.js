// 1. 일반함수
let obj = { result: 0 };

obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
  }
  // 일반함수이기 때문에 호출 시 this가 결정됨
  // this -> window
  inner();

  // 참고로, 여기에 this가 쓰였다면 add를 가리킬 것.
};

obj.add(3, 4);

console.log(obj);
console.log(result);
