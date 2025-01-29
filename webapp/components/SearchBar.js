import { MagnifyingGlassIcon } from '@heroicons/react/24/outline';

export default function SearchBar({ onSearch }) {
  return (
    <div className="search-bar">
      <MagnifyingGlassIcon className="search-icon" />
      <input
        type="text"
        placeholder="Search files..."
        onChange={(e) => onSearch(e.target.value)}
      />
      <button className="image-search-btn">
        <PhotoIcon className="h-5 w-5" />
      </button>
    </div>
  )
}