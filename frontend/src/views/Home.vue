<template>
  <div>
    <news></news>
    <activity-feed :data="homeActivityFeed"/>
  </div>
</template>

<script>

import ActivityFeed from "@/components/ActivityFeed";
import News from "@/components/News";

export default {
  name: 'Home',
  components: {News, ActivityFeed},
  data() {
    return {
      homeActivityFeed: [
        {
          user: 'Markus',
          activity: {
            title: 'testHomeActivity - 1',
            description: 'hey this is a testActivity done by Markus!',
            date: new Date(),
          },
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          user: 'Thomas',
          activity: {
            title: 'testHomeActivity - 2',
            description: 'hey this is a testActivity done by Thomas!',
            date: new Date(),
          },
          color: 'purple',
          icon: 'mdi-book-variant',
        },
      ],
    }
  },
}
</script>

<style>
</style>
