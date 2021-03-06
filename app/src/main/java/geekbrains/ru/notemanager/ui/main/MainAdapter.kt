package geekbrains.ru.notemanager.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import geekbrains.ru.notemanager.model.Note
import geekbrains.ru.notemanager.R
import geekbrains.ru.notemanager.model.Color

class MainAdapter(private val onItemClickListener: (Note) -> Unit) : RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int): Unit {
        holder.bind(notes[position])
    }

    @Suppress("DEPRECATION")
    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val body = itemView.findViewById<TextView>(R.id.body)

        fun bind(note: Note) {
            with(note) {
                val color = when (color) {
                    Color.WHITE -> R.color.color_white
                    Color.VIOLET -> R.color.color_violet
                    Color.YELLOW -> R.color.color_yello
                    Color.RED -> R.color.color_red
                    Color.PINK -> R.color.color_pink
                    Color.GREEN -> R.color.color_green
                    Color.BLUE -> R.color.color_blue
                }

                itemView.setBackgroundColor(itemView.context.resources.getColor(color))
                this@NoteViewHolder.title.text = title
                body.text = this.note
                itemView.setOnClickListener { onItemClickListener(note) }
            }
        }
    }

}
