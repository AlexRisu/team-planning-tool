<template>
  <v-container>
    <v-card>
      <v-card-title>
        News
      </v-card-title>
      <v-card-title>
        {{ newsData }}
      </v-card-title>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "News",
  data() {
    return {
      newsData: undefined,
    }
  }
}
</script>

<style scoped>

</style>