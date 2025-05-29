// 일반 함수 ver
const test1 = function (a, b) {
  return a + b;
};

// 화살표 함수 ver
const test2 = (a, b) => {
  return a + b;
};

// 화살표 함수 return 한줄일 때 생략 ver
const test3 = (a, b) => a + b;

console.log(test1(3, 4));
console.log(test2(3, 4));
console.log(test3(3, 4));
