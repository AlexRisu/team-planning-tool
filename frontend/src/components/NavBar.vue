<template>
  <div class="nav-container">
    <router-link to="Home">Home</router-link>
    <router-link to="About">About</router-link>

    <router-link to="Profile" class="profile">
      <v-avatar rounded color="red"></v-avatar>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "NavBar",
}
</script>

<style scoped>

.nav-container {
  width: 100%;
  height: 50px;
  background-color: rgba(38, 36, 36, 0.96);
  display: flex;
}

.nav-container * {
  width: fit-content;
  padding-left: 25px;
  padding-right: 25px;
  margin-top: auto;
  margin-bottom: auto;
  text-decoration: none;
  color: whitesmoke;
  height: max-content;
}

.nav-container *:hover {
  color: wheat;
}

.profile {
  position: absolute;
  right: 0;
  padding-left: 25px;
  padding-right: 25px;
}
</style>