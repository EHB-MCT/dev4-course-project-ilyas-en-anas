

<template>
  <main>
    <h1>this is homepage</h1>
  </main>
</template>

<script>
export default {
  mounted() {
    if (!localStorage.getItem('refreshed')) {
      localStorage.setItem('refreshed', 'true');
      location.reload();
    } else {
      localStorage.removeItem('refreshed');
    }
  },
};
</script>
