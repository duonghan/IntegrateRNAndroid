const urlGetMovies = 'http://5b616f9e07412d00142acdf9.mockapi.io/movies';
const urlPostMovies = 'http://localhost:3000/movies';

function* getMoviesFromApi() {

    const response = yield fetch(urlGetMovies, {
        method: 'GET',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
        body: '',
    });

    const movies = yield response.status === 200 ? JSON.parse(response._bodyInit) : [];

    return movies;
}

//send POST request to add new Movie
function* insertNewMovieFromApi(newMovie) {
    const response = yield fetch(urlPostMovies, {
        method: 'POST',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            name: newMovie.name,
            releaseYear: newMovie.releaseYear,
        }),
    });
    yield console.log(`response = ${JSON.stringify(response)}`);
    return yield (response.status === 201);//true or false
}

export const Api = {
    getMoviesFromApi,
    insertNewMovieFromApi
};