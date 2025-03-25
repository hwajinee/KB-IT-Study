<template>
  <div>
    <!-- @이벤트명 : 이때, 이벤트명은 자식에서 보낸 이벤트명과 동일해야 한다.
    이후, 받아온 이벤트를 이벤트 핸들러와 연결 -->
    <InputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터: {{ parentName }}</h3>
  </div>
</template>

<script>
import InputName from './components/InputName.vue';
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
