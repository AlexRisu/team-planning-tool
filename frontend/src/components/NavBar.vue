<template>
  <div class="nav-container">
    <router-link to="/">Home</router-link>
    <router-link to="Calendar">Calendar</router-link>
    <router-link to="About">About</router-link>
    <div class="profile">
      <v-avatar class="clickable" rounded color="red" @click="$router.push('Profile')">
      </v-avatar>
      <v-btn icon color="white">
        <v-icon>
          mdi-cog
        </v-icon>
      </v-btn>
    </div>
  </div>
</template>

<script>
export default {
  name: "NavBar",
  components: {},

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
}

.clickable {
  cursor: pointer;
}
</style>