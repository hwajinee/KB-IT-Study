const hwajin = {
  firstName: 'hwajin',
  lastName: 'choi',
  getFullName: function () {
    return `${this.firstName} ${this.lastName}`;
  },
};

// 일반 함수에서 this는 호출한 객체를 가리킨다.
console.log(hwajin.getFullName());

// 위와 같이 하면 매번 hwajine, yura와 같은 이름 객체를 각각 만들어야 함.
// 생성자의 기능을 하는 함수 user를 만든다.

// 생성자 함수
function User(first, last) {
  this.firstName = first;
  this.lastName = last;
}

// 변수는 위와 같이 만들 수 있지만, 함수는 ?
// prototype으로 만들 수 있음 *
// 프로토타입에 추가된 함수는 객체 전체가 공유한다.
User.prototype.getFullName = function () {
  return `${this.firstName} ${this.lastName}`;
};

const yura = new User('yura', 'choi');
const jiwon = new User('jiwon', 'park');

console.log(yura.getFullName());
console.log(jiwon.getFullName());

// 이렇게만 해도 클래스처럼 사용할 수 있었음.
// ES6 부터는 클래스 개념이 도입됨 !
// 그래도 내부를 보면 프로토타입 형식이기 때문에 자바스크립트는 클래스 기반이 아닌 프로토타입 기반 언어라고 한다.
