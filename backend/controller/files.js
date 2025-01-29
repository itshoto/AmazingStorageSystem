const File = require('../models/File');

exports.searchFiles = async (req, res) => {
  try {
    const { query } = req.query;
    const files = await File.find({
      name: { $regex: query, $options: 'i' }
    });
    res.json(files);
  } catch (error) {
    res.status(500).json({ message: 'Search failed' });
  }
}
