import org.grouplens.lenskit.transform.normalize.ItemVectorNormalizer
import org.grouplens.lenskit.transform.normalize.MeanCenteringVectorNormalizer
import org.grouplens.lenskit.transform.normalize.VectorNormalizer
import org.lenskit.api.ItemScorer
import org.lenskit.baseline.BaselineScorer
import org.lenskit.baseline.ItemMeanRatingItemScorer
import org.lenskit.baseline.UserMeanBaseline
import org.lenskit.baseline.UserMeanItemScorer
import org.lenskit.knn.NeighborhoodSize
import org.lenskit.knn.item.ItemItemScorer
import org.lenskit.knn.item.ModelSize
import org.lenskit.knn.item.model.ItemItemBuildContext
import org.lenskit.knn.item.model.ItemwiseBuildContextProvider

bind ItemScorer to ItemItemScorer
set NeighborhoodSize to 20
set ModelSize to 2000
bind ItemItemBuildContext toProvider ItemwiseBuildContextProvider
within (ItemVectorNormalizer) {
    bind VectorNormalizer to MeanCenteringVectorNormalizer
}
bind (BaselineScorer, ItemScorer) to UserMeanItemScorer
bind (UserMeanBaseline, ItemScorer) to ItemMeanRatingItemScorer
