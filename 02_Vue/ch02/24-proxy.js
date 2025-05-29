let obj = { name: '제니', age: 27 };
const proxy = new Proxy(obj, {
  get: function () {},
  set: function () {},
});

console.log(proxy.name);
proxy.name = '로제';
proxy.age = 30;
console.log(proxy);
