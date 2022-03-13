
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.whiterabbit.machinetest.R
import com.whiterabbit.machinetest.data.models.Employee
import com.whiterabbit.machinetest.databinding.EmployeeListItemBinding

class EmployeeListAdapter(private val onClick: (employee: Employee) -> Unit,
) : ListAdapter<Employee, EmployeeListAdapter.EmployeeListViewHolder>(DIFF_CALLBACK) {

        inner class EmployeeListViewHolder(binding: EmployeeListItemBinding): RecyclerView.ViewHolder(binding.root) {
            private val itemBinding = binding

            fun bind (
                employee: Employee,
                onClick: (employee: Employee) -> Unit
            ) {
                itemBinding.apply {
                    tvEmployeeName.text = employee.name
                    tvCompanyName.text = employee.employeeCompany?.name

                    Glide.with(itemView)
                        .load(employee.profileImage)
                        .centerCrop()
                        .placeholder(
                            ContextCompat.getDrawable(itemView.context,
                                R.drawable.ic_round_person_outline_24))
                        .error(R.drawable.ic_round_person_outline_24)
                        .into(itemBinding.ivEmployeePic)

                    itemView.setOnClickListener {
                        onClick(employee)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListViewHolder {
        val itemBinding = EmployeeListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return EmployeeListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: EmployeeListViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Employee>() {
            override fun areItemsTheSame(
                oldItem: Employee,
                newItem: Employee,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Employee,
                newItem: Employee,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}