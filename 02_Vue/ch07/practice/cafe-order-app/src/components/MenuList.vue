<template>
  <h2>메뉴 선택</h2>
  <button class="btn-style" v-for="menu in menus">
    {{ menu.name }} ({{ menu.price }}원)
  </button>
</template>

<script>
export default {
  name: 'MenuList',
  data() {
    return {};
  },
  props: ['menus'],
};
</script>

<style scoped>
.btn-style {
  background-color: rgb(173, 173, 173);
  margin: 5px;
  padding: 10px;
}
</style>
