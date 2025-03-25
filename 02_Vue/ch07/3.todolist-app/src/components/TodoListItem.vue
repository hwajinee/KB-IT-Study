<template>
  <li
    class="list-group-item"
    :class="{ 'list-group-item-success': todoItem.completed }"
    @click="$emit('toggle-completed', todoItem.id)"
  >
    <span class="pointer" :class="{ 'todo-done': todoItem.completed }">
      {{ todoItem.todo }} {{ todoItem.completed ? '(완료)' : '' }}
    </span>
    <span
      class="float-end badge bg-secondary pointer"
      @click.stop="$emit('delete-todo', todoItem.id)"
      >삭제</span
    >
  </li>
</template>

<script>
export default {
  name: 'TodoListItem',
  props: {
    // 부모로부터 받아온 todoItem
    todoItem: { type: Object, required: true },
  },
  // 자식에게 받아온 이벤트 부모에게 그대로 전달
  // (이 컴포넌트는 두 함수에 대해 TodoListItem과 App 사이의 중개 역할을 함. )
  emits: ['delete-todo', 'toggle-completed'],
};
</script>
