stable_bloom_filter
===================

Stable Bloom Filter implementation.

Based on the document linked below:
<a href="http://www.cs.ualberta.ca/~drafiei/papers/DupDet06Sigmod.pdf">
Approximately Detecting Duplicates for Streaming Data using Stable Bloom Filters, by
Fan Deng and Davood Rafiei, University of Alberta</a>

Similar interface to <a hred="https://github.com/google/guava">Google Guava's BloomFilter</a>.
Implementation leverages some of the Guava's code from <a href="https://github.com/google/guava/blob/master/guava/src/com/google/common/hash/BloomFilter.java">com.google.common.hash.BloomFilter</a> and <a href="https://github.com/google/guava/blob/master/guava/src/com/google/common/hash/BloomFilterStrategies.java">com.google.common.hash.BloomFilterStrategies</a>.

Copyright (C) 2016, ru2nuts.
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
