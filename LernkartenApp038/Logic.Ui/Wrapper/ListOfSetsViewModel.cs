using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.CompilerServices;
using System.Collections.ObjectModel;
using De.HsFlensburg.LernkartenApp038.Business.Model.BusinessObjects;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels.Common;
using System.ComponentModel;
using System.Collections.Specialized;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper
{
    [Serializable]
    public class ListOfSetsViewModel: ObservableCollection<SetViewModel>, INotifyPropertyChanged
    {
        public ListOfSets list;
        private bool syncDisabled = false;

        public ListOfSetsViewModel()
        {
            list = new ListOfSets();
        }

        private void ViewModelCollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (syncDisabled) return;
            syncDisabled = true;

            switch (e.Action)
            {
                case NotifyCollectionChangedAction.Add:
                    foreach (var set in e.NewItems.OfType<SetViewModel>().Select(v => v.set).OfType<Set>())
                        list.Add(set);
                    break;
                case NotifyCollectionChangedAction.Remove:
                    foreach (var set in e.OldItems.OfType<SetViewModel>().Select(v => v.set).OfType<Set>())
                        list.Remove(set);
                    break;
                case NotifyCollectionChangedAction.Reset:
                    list.Clear();
                    break;
            }
            syncDisabled = false;
        }

        private void ModelCollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (syncDisabled) return;
            syncDisabled = true;

            switch (e.Action)
            {
                case NotifyCollectionChangedAction.Add:
                    foreach (var set in e.NewItems.OfType<Set>())
                        Add(new SetViewModel(set));
                    break;
                case NotifyCollectionChangedAction.Remove:
                    foreach (var set in e.OldItems.OfType<Set>())
                        Remove(GetViewModelOfModel(set));
                    break;
                case NotifyCollectionChangedAction.Reset:
                    this.Clear();
                    break;
            }
            syncDisabled = false;
        }

        private SetViewModel GetViewModelOfModel(Set set)
        {
            foreach (SetViewModel svm in this)
            {
                if (svm.set.Equals(set)) return svm;
            }
            return null;
        }

    }
}
