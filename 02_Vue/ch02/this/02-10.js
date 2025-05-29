let obj = { result: 0 };
obj.add = function (x, y) {
  this.result = x + y;
};

// 일반 함수는 호출할 때 this가 결정됨.
obj.add(3, 4);
console.log(obj);
