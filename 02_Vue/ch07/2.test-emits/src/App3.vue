<template>
  <div>
    <InputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터: {{ parentName }}</h3>
  </div>
</template>

<script>
import InputName from './components/InputName3.vue';
export default {
  name: 'App',
  components: { InputName },
  data() {
    return {
      parentName: '',
    };
  },
  methods: {
    nameChangedHandler(e) {
      // 자식에게서 받아온 name을 부모 컴포넌트에 적용
      this.parentName = e.name;
    },
  },
};
</script>

<style scoped>
/* style태그에 scoped를 쓰면, 해당 파일에만 style을 적용할 것이라는 뜻 */
</style>
