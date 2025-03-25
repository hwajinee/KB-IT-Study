<template>
  <div>
    <h2>관심있는 K-POP가수</h2>
    <hr />
    <ul>
      <!-- :name과 :checked는 자식에게 전달할 props -->
      <CheckboxItem v-for="idol in idols" :key="idol.id" :idol="idol" />
    </ul>
  </div>
  <main></main>
</template>

<script>
import CheckboxItem from './components/CheckboxItem2.vue';
export default {
  name: 'App',
  components: { CheckboxItem },
  data() {
    return {
      idols: [
        { id: 1, name: '블랙핑크', checked: true },
        { id: 2, name: 'BTS', checked: false },
        { id: 3, name: '샤이니', checked: false },
        { id: 4, name: '엑소', checked: false },
      ],
    };
  },
};
</script>

<style scoped>
/* style태그에 scoped를 쓰면, 해당 파일에만 style을 적용할 것이라는 뜻 */
</style>
