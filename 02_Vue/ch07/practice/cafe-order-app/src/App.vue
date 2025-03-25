<template>
  <h1>카페 주문 앱</h1>
  <h3>메뉴 선택</h3>
  <div class="menu-box">메뉴</div>
  <MenuList />
</template>

<script>
import MenuList from './components/MenuList.vue';

export default {
  name: 'App',
  components: { MenuList },
  data() {
    return {
      menuList: [
        { name: '아메리카노', price: 4000 },
        { name: '카페라떼', price: 4500 },
        { name: '바닐라라떼', price: 4800 },
        { name: '콜드브루', price: 5000 },
      ],
    };
  },
};
</script>

<style scoped></style>
