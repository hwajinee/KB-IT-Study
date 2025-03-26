<template>
  <!-- 체크 여부에 따라 이모지 얼굴 변경 -->
  <li><i class="song.done? icons.checked : icons.unchecked"></i></li>
  {{ song.title }}
</template>

<script>
export default {
  name: 'SongListItem',
  //   App.vue에서 provide한 속성 주입받기
  inject: ['icons'],
  //   SongList.vue에서 받아온 속성
  props: ['song'],
};
</script>
