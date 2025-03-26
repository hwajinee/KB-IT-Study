<template>
  <div>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />

    <!-- <span
      v-if="checked === true"
      style="color: blue; text-decoration: underline"
    >
      <i>{{ label }}</i></span
    >
    <span v-else style="color: gray">{{ label }}</span> -->
    <slot>Item</slot>
  </div>
</template>

<script>
export default {
  name: 'CheckBox2',
  props: ['id', 'checked'],
};
</script>

<style scoped></style>
