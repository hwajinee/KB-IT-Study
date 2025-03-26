<template>
  <div>
    <slot name="icon">Icon</slot>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <slot name="label">Item</slot>
  </div>
</template>

<script>
export default {
  name: 'CheckBox3',
  props: ['id', 'checked'],
};
</script>

<style scoped></style>
