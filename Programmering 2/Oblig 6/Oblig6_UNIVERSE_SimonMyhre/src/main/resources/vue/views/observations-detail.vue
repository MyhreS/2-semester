<template id="observations-detail">
    <div class="content-wrapper">
        <div class="detail-planet-system-container">
            <img v-if="observations.pictureUrl" class="cover-image" v-bind:src="observations.pictureUrl">
            {{console.log(this.observations)}}

            <h1>{{animaltype.name}}</h1>
            <p> There was spotted a new animal "{{animaltype.name}}" who looks like is a type of "{{observations.name}}" </p>
            <p>
                <a class="button" :href="`/api/observations/${observations.id}/delete`">Delete</a>
                <a class="button" :href="`/observations/${observations.id}/update`">Edit</a>
            </p>

        </div>
    </div>
</template>
<script>
    Vue.component("observations-detail", {
        template: "#observations-detail",
        data: () => ({
            observations: "",
            animaltype: null,
        }),
        created() {
            const observationsId = this.$javalin.pathParams["observations-id"];
            fetch(`/api/observations/${observationsId}`)
                .then(res => res.json())
                .then(res => {
                    this.observations = res
                    this.animaltype = this.observations.animal
                })
        }
    });
</script>
<style>
    div.detail-planet-system-container{
        padding: 10px;
        overflow: hidden;
        width: 750px;
        margin: 0 auto;
        background-color: rgba(20, 20, 20, 0.98);
        opacity: 0.96;
        color: white;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.cover-image {
        height: auto;
        width: 50%;
        margin: 5px;
        float: left;
    }

    h1{
        font-size:18px;
        padding-top: 10px;
    }

    .button {
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    button a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    .button:hover{
        border: 2px solid white;
    }

</style>
