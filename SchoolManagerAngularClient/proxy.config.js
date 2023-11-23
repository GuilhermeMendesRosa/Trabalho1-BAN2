const proxy = [
  {
    context: '/api',
    target: 'http://java-app:8080',
    pathRewrite: {'^/api' : ''}
  }
];
module.exports = proxy;
