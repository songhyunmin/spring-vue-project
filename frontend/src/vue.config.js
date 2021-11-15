module.exports = {
  devServer: {
    overlay : false
  },
  rules: [{
      test: /@?(BaseChart).*\.(ts|js)x?$/,
      loader: 'babel-loader'
  }]
};