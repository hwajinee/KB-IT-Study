<template>
  <div>
    <h2>App 컴포넌트</h2>
    <hr />
    <!-- CheckboxItem을 쓰려면 script에 등록해줘야 함. -->
    <ul>
      <CheckboxItem />
      <CheckboxItem />
      <CheckboxItem />
      <CheckboxItem />
    </ul>
  </div>
  <main></main>
</template>

<script>
import CheckboxItem from './components/CheckboxItem.vue';

export default {
  name: 'App',
  // 지역 컴포넌트 등록 방법, 해당 vue에서만 사용 가능
  components: { CheckboxItem },
};
</script>

<style scoped>
/* style태그에 scoped를 쓰면, 해당 파일에만 style을 적용할 것이라는 뜻 */
</style>
