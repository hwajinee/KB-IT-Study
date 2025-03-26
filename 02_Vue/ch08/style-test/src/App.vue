<template>
  <div>
    <Child1 />
    <Child2 />
    <Child3 />
  </div>
</template>

<script>
// 가장 마지막에 import한 색상으로 스타일이 적용된다.
import Child1 from './components/Child1.vue';
import Child2 from './components/child2.vue';
import Child3 from './components/child3.vue';

export default {
  name: 'App',
  components: { Child1, Child2, Child3 },
};
</script>

<style scoped></style>
