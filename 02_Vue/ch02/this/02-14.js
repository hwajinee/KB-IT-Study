// 2. 일반함수이지만, bind로 this지정
let obj = { result: 0 };
obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
  }
  // add의 this를 inner의 this에 지정 !
  inner = inner.bind(this);
  inner();
};

obj.add(3, 4);
console.log(obj);
// console.log(result); - err : 전역변수 result는 생성되지 않음.
